package com.juancuero.input.rest.controller.query;

import com.juancuero.input.rest.controller.command.mapper.ClientRestMapper;
import com.juancuero.input.rest.controller.command.response.ClientResponse;
import com.juancuero.model.Client;
import com.juancuero.output.jpa.adapter.JpaClientQueryAdapter;
import com.juancuero.model.pagination.Pagination;
import com.juancuero.model.pagination.PageBase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("clients")
@AllArgsConstructor
public class FindAllClientController {

    private final JpaClientQueryAdapter clientQueryAdapter;
    private final ClientRestMapper mapper;

    @GetMapping
    public ResponseEntity<PageBase<ClientResponse>> findAll(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size) {

        size = Math.max(size, 1);
        page = Math.max(page, 0);

        Pagination pagination = new Pagination(page, size, "", "");

        PageBase<Client> clientPage = clientQueryAdapter.findAll(pagination);

        PageBase<ClientResponse> response = new PageBase<>(
                clientPage.getPage(),
                clientPage.getSize(),
                clientPage.getTotalPages(),
                clientPage.getTotalElements(),
                clientPage.isEmpty(),
                clientPage.getContent().stream()
                        .map(mapper::toResponse)
                        .toList()
        );

        return ResponseEntity.ok(response);
    }

}
