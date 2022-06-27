package com.lld.splitwise;

import com.lld.splitwise.commands.RegisterUserCommand;
import com.lld.splitwise.commands.UpdateProfileCommand;
import com.lld.splitwise.commands.registry.CommandRegistry;
import com.lld.splitwise.commands.registry.CommandRegistryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SplitWiseApplication implements CommandLineRunner {

    @Autowired
    private CommandRegistry commandRegistry;

    @Autowired
    private RegisterUserCommand registerUserCommand;

    @Autowired
    private UpdateProfileCommand updateProfileCommand;
    public static void main(String[] args) {
        SpringApplication.run(SplitWiseApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        commandRegistry.registerCommand(registerUserCommand);
        commandRegistry.registerCommand(updateProfileCommand);

        String input = "Register vinsmokesanji 003 namisswwaann";
        String input2 = "1 UpdateProfile robinchwan";
        commandRegistry.executeCommandLine(input2);
//        while (true){
//            String input = "Input from Console";
//            commandRegistry.executeCommandLine(input);
//        }
    }
}
