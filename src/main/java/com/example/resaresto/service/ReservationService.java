package com.example.resaresto.service;

import com.example.resaresto.model.Reservation;
import com.example.resaresto.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }
    public List<Reservation> getReservationsForDateRange(LocalDateTime start, LocalDateTime end){
        return reservationRepository.findAllByReservationDateTimeBetween(start, end);
    }
    public Reservation getReservation(Long id){
        return reservationRepository.findById(id).orElse(null);
    }
    public Reservation saveReservation(Reservation reservation){
        return reservationRepository.save(reservation);
    }
    public void deleteReservation(Long id){
        reservationRepository.deleteById(id);
    }
}
