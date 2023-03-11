package vargas.alejandro.demo.controllers;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vargas.alejandro.demo.dtos.UserDto;
import vargas.alejandro.demo.entities.User;
import vargas.alejandro.demo.services.UsersService;

@RestController
@RequestMapping("/users")
public class UsersController {

    private final ModelMapper modelMapper;
    private final UsersService usersService;

    public UsersController(ModelMapper modelMapper, UsersService usersService) {
        this.modelMapper = modelMapper;
        this.usersService = usersService;
    }

    @PostMapping
    public UserDto create(@Valid @RequestBody UserDto userDto) {
        User user = usersService.create(modelMapper.map(userDto, User.class));
        return modelMapper.map(user, UserDto.class);
    }
}
