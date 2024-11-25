package com.alquilercoches.coches.controllers;

import java.security.Principal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.alquilercoches.coches.appdata.AppDataImpl;

@Controller
public class LoginController {

	private final AppDataImpl appData;

	public LoginController(AppDataImpl appData) {
		this.appData = appData;
	}

	@GetMapping("/login")
	public String login(
			@RequestParam(value="error", required=false) String error,
			@RequestParam(value="logout", required=false) String logout,
			Model model, Principal principal, RedirectAttributes flash) {

		// Si el usuario ya está autenticado, redirigirlo a la página principal
		if (principal != null)
			return "redirect:/";

		// Si hubo un error en el login
		if (error != null)
			model.addAttribute("error", "Credenciales incorrectas.");

		// Si el usuario ha cerrado sesión con éxito
		if (logout != null)
			model.addAttribute("success", "Has cerrado sesión con éxito.");

		model.addAttribute("applicationData", appData);
		return "login/login"; // Página de login
	}
}
