package com.example.resaresto.controller;

import com.example.resaresto.model.Reservation;
import com.example.resaresto.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("api/reservations")
@CrossOrigin(origins ="*")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping
    public List<Reservation> getAllReservations(){
        return reservationService.getAllReservations();
    }
    @GetMapping("/today")
    public List<Reservation> getReservationsForToday(){
        LocalDate today = LocalDate.now();
        LocalDateTime startToday= today.atStartOfDay();
        LocalDateTime endToday = today.atTime(LocalTime.MAX);
        return reservationService.getReservationsForDateRange(startToday, endToday);
    }
    @GetMapping("/week")
    public List<Reservation> getReservationsForThisWeek(){
        LocalDate today = LocalDate.now();
        LocalDate startOfWeek = today.with(DayOfWeek.MONDAY);
        LocalDate endOfWeek = today.with(DayOfWeek.SUNDAY);
        LocalDateTime start = startOfWeek.atStartOfDay();
        LocalDateTime end = endOfWeek.atTime(LocalTime.MAX);
        return reservationService.getReservationsForDateRange(start, end);
    }
    @GetMapping("/{id}")
    public Reservation getReservation(@PathVariable Long id) {
        return reservationService.getReservation(id);
    }
    @PostMapping
    public Reservation createReservation(@RequestBody Reservation reservation){
        return reservationService.saveReservation(reservation);
    }
    @PutMapping("/{id}")
    public Reservation updateReservation(@PathVariable Long id, @RequestBody Reservation reservation){
        Reservation existingReservation = reservationService.getReservation(id);
        if (existingReservation !=null) {
            reservation.setId(id);
            return reservationService.saveReservation(reservation);
        }else{
            throw new RuntimeException("Reservation not found");
        }
    }
    @DeleteMapping("/{id}")
    public void deleteReservation(@PathVariable Long id){
        reservationService.deleteReservation(id);
    }
}
