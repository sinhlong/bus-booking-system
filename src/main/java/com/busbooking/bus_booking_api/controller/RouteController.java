package com.busbooking.bus_booking_api.controller;

import com.busbooking.bus_booking_api.entity.Route;
import com.busbooking.bus_booking_api.service.RouteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/route")
public class RouteController {
    private final RouteService routeService;

    public RouteController(RouteService routeService){
        this.routeService = routeService;
    }

    @GetMapping
    public List<Route> getAllRoute(){
        return routeService.getAllRoute();
    }

    @GetMapping("/{id}")
    public Route getRouteById(@PathVariable Integer id){
        return routeService.getRouteById(id);
    }

    @PostMapping
    public Route createRoute(@RequestBody Route route){
        return routeService.createRoute(route);
    }

    @PutMapping("/{id}")
    public Route updateRoute(
            @PathVariable Integer id,
            @RequestBody Route route
    ){
        return  routeService.updateRoute(id,route);
    }

    @DeleteMapping("/{id}")
    public boolean deleteRouteById(@PathVariable Integer id ){
        return routeService.deleteRoute(id);
    }
}
