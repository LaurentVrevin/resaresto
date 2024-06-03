package com.example.resaresto.repository;

import com.example.resaresto.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findAllByReservationDateTimeBetween(LocalDateTime start, LocalDateTime end);
}
