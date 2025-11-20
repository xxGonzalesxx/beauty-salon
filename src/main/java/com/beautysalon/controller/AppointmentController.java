package com.beautysalon.controller;

import com.beautysalon.entity.Appointment;
import com.beautysalon.entity.Client;
import com.beautysalon.entity.Master;
import com.beautysalon.entity.SalonService;
import com.beautysalon.service.AppointmentService;
import com.beautysalon.service.ClientService;
import com.beautysalon.service.MasterService;
import com.beautysalon.service.SalonServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/appointments")
@RequiredArgsConstructor
public class AppointmentController {
    private final AppointmentService appointmentService;
    private final SalonServiceService salonServiceService;
    private final MasterService masterService;
    private final ClientService clientService;

    @GetMapping("/book")
    public String showBookingForm(Model model) {
        List<SalonService> services = salonServiceService.getAllServices();
        List<Master> masters = masterService.getAllMasters();

        model.addAttribute("services", services);
        model.addAttribute("masters", masters);
        model.addAttribute("appointment", new Appointment());
        return "appointments/book";
    }

    @PostMapping("/book")
    public String bookAppointment(@ModelAttribute Appointment appointment,
                                  @RequestParam Long clientId,
                                  @RequestParam Long serviceId,
                                  @RequestParam Long masterId) {
        Client client = clientService.getClientById(clientId)
                .orElseThrow(() -> new RuntimeException("Client not found"));
        SalonService service = salonServiceService.getServiceById(serviceId)
                .orElseThrow(() -> new RuntimeException("Service not found"));
        Master master = masterService.getMasterById(masterId)
                .orElseThrow(() -> new RuntimeException("Master not found"));

        appointment.setClient(client);
        appointment.setService(service);
        appointment.setMaster(master);

        appointmentService.createAppointment(appointment);
        return "redirect:/appointments/success";
    }

    @GetMapping("/success")
    public String bookingSuccess() {
        return "appointments/success";
    }

    @GetMapping("/my")
    public String getMyAppointments(@RequestParam Long clientId, Model model) {
        List<Appointment> appointments = appointmentService.getAppointmentsByClient(clientId);
        model.addAttribute("appointments", appointments);
        return "appointments/my";
    }

    @PostMapping("/{id}/cancel")
    public String cancelAppointment(@PathVariable Long id) {
        appointmentService.cancelAppointment(id);
        return "redirect:/appointments/my?clientId=" + id;
    }
}