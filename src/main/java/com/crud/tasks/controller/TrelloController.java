package com.crud.tasks.controller;

import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.trello.client.TrelloClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/trello")
public class TrelloController {

    private final TrelloClient trelloClient;

    public TrelloController(TrelloClient trelloClient) {
        this.trelloClient = trelloClient;
    }

    @GetMapping("getTrelloBoards")
    public void getTrelloBoards(){
        List<TrelloBoardDto> trelloBoards = trelloClient.getTrelloBoards();

        trelloBoards
                .stream()
                .filter(trelloBoardDto -> trelloBoardDto.getName().contains("Kodilla"))
                .forEach(trelloBoardDto -> {
                    System.out.println(trelloBoardDto.getId() + " " + trelloBoardDto.getName());
                });
    }
}
