package todo.backend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import todo.backend.entity.Card;
import todo.backend.exception.NotFoundException;
import todo.backend.service.CardService;

import javax.validation.Valid;

@RestController
@RestControllerAdvice
@RequestMapping("/todo/cards")
public class CardController {

	private final CardService cardService;

	public CardController(CardService cardService) {
		this.cardService = cardService;
	}

	@GetMapping("")
	@ResponseStatus(HttpStatus.OK)
	public List<Card> getCards() {
		return cardService.getCards();
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Card getCard(@PathVariable Long id){
		return cardService.getCard(id);
	}

	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public Card createCard(@RequestBody @Valid Card card) {
		return cardService.createCard(card);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Card updateCard(@PathVariable Long id, @RequestBody Card card) {
		return cardService.updateCard(id, card);
	}

	// TODO: implement - delete card
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteCard(@PathVariable Long id){
		cardService.deleteCard(id);
	}

}
