import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ReservationService } from '../../services/reservation.service';
import { Reservation } from '../../models/reservation';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-reservation-form',
  templateUrl: './reservation-form.component.html',
  styleUrls: ['./reservation-form.component.css']
})
export class ReservationFormComponent implements OnInit {
  reservationForm: FormGroup;
  reservationId: number | null = null;

  constructor(
    private fb: FormBuilder,
    private reservationService: ReservationService,
    private route: ActivatedRoute,
    private router: Router,
    private snackBar: MatSnackBar
  ) {
    this.reservationForm = this.fb.group({
      customerName: ['', Validators.required],
      numberOfPeople: ['', Validators.required],
      reservationDateTime: ['', Validators.required],
      comments: ['']
    });
  }

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      const id = params.get('id');
      if (id) {
        this.reservationId = +id;
        this.reservationService.getReservation(this.reservationId).subscribe((reservation: Reservation) => {
          this.reservationForm.patchValue(reservation);
        });
      }
    });
  }

  onSubmit(): void {
    if (this.reservationForm.valid) {
      const reservation: Reservation = this.reservationForm.value;
      if (this.reservationId) {
        this.reservationService.updateReservation(this.reservationId, reservation).subscribe(() => {
        this.snackBar.open('Reservation updated successfully!', 'close', { duration: 3000 })
          this.router.navigate(['/reservations']);
        });
      } else {
        this.reservationService.createReservation(reservation).subscribe(() => {
        this.snackBar.open('Reservation created successfully', 'close', { duration: 3000})
          this.router.navigate(['/reservations']);
        });
      }
    }
  }
}
