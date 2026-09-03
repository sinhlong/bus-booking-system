package com.busbooking.bus_booking_api.service;

import com.busbooking.bus_booking_api.entity.Route;
import com.busbooking.bus_booking_api.repository.RouteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteService {
    private final RouteRepository routeRepository;

    public RouteService(RouteRepository routeRepository){
        this.routeRepository = routeRepository;
    }

    public List<Route> getAllRoute(){
        return routeRepository.findAll();
    }

    public Route getRouteById(Integer id){
        return routeRepository.findById(id).orElse(null);
    }

    public Route createRoute(Route route){
        return routeRepository.save(route);
    }

    public Route updateRoute(Integer id,Route route){
        Route existingRoute = routeRepository.findById(id).orElse(null);

        if(existingRoute == null){
            return null;
        }

        existingRoute.setRouteOrigin(route.getRouteOrigin());
        existingRoute.setRouteDestination(route.getRouteDestination());
        existingRoute.setRouteDistance(route.getRouteDistance());

        return routeRepository.save(existingRoute);
    }

    public boolean deleteRoute(Integer id){
        if(!routeRepository.existsById(id)){
            return false;
        }

        routeRepository.deleteById(id);
        return true;
    }
}
