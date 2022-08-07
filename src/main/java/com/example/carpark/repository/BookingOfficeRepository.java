package com.example.carpark.repository;

import com.example.carpark.entity.Bookingoffice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;

public interface BookingOfficeRepository extends JpaRepository<Bookingoffice,Long> {
//    @Query(value = "update bookingoffice set end_contract_deadline = ?1, office_name =?2, office_phone=?3, office_place =?4, office_price =?5, start_contract_deadline = ?6 where office_id = ?7", nativeQuery = true)
//    @Modifying
//    void updateBookingoffice(LocalDate endContractDeadline,String officeName, String officePhone, String officePlace, Long officePrice,LocalDate startContractDeadline, Long officeId);

}
