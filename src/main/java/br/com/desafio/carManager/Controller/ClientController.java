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

import br.com.desafio.carManager.DTO.ClientDTO;
import br.com.desafio.carManager.Entity.Client;
import br.com.desafio.carManager.Form.ClientForm;
import br.com.desafio.carManager.Repository.ClientRepository;

@RestController
@RequestMapping("/clients")
public class ClientController {
	
	@Autowired
	ClientRepository clientRepository;
	
	@GetMapping
	public List<ClientDTO> list(){
		List<Client> clients = clientRepository.findAll();
		return ClientDTO.convert(clients);
	}
	
	@PostMapping
	public ResponseEntity<ClientDTO> salvar(@RequestBody @Valid ClientForm form, 
			UriComponentsBuilder uriBuilder){
		Client client = form.convert();
		clientRepository.save(client);
		URI uri = uriBuilder.path("/clients/{id}").buildAndExpand(client.getId()).toUri();
		return ResponseEntity.created(uri).body(new ClientDTO(client));
	}
}
