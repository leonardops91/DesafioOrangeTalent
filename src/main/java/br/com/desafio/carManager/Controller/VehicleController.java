package br.com.desafio.carManager.Controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.desafio.carManager.DTO.VehicleDTO;
import br.com.desafio.carManager.Entity.Vehicle;
import br.com.desafio.carManager.Form.VehicleForm;
import br.com.desafio.carManager.Repository.VehicleRepository;
import br.com.desafio.carManager.Service.VehicleService;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

	
	@Autowired
	private VehicleRepository vehicleRepository;
	
	@GetMapping
	public List<VehicleDTO> List() {
		List<Vehicle> vehicles = vehicleRepository.findAll();
		return VehicleDTO.convert(vehicles);
	}
	
	@PostMapping
	public ResponseEntity<VehicleDTO> salvar(@RequestBody @Valid VehicleForm form, UriComponentsBuilder uriBuilder){
		VehicleService.isVehicleValid(form.getBrand(), form.getModel(), form.getYear());
		Vehicle vehicle = form.convert();
		vehicle.setPrice(VehicleService.getPrice());
		vehicleRepository.save(vehicle);
		URI uri = uriBuilder.path("/vehicles/{id}").buildAndExpand(vehicle.getId()).toUri();
		return ResponseEntity.created(uri).body(new VehicleDTO(vehicle));
	}
	
	
}
