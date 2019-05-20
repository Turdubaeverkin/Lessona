package kg.Lessons.Lessona.controller;
import kg.Lessons.Lessona.model.Hello;
import kg.Lessons.Lessona.model.Message;
import kg.Lessons.Lessona.repository.HelloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
@RestController
public class HelloController {
      @Autowired
    private HelloRepository helloRepository;

    @GetMapping("/hello")
    public String MyHello(String name) {
        return "Hello, " + name;
    }

    @GetMapping("/hello/12")
    public String Hello1(@RequestParam("name") String name) {
        return "Hello" + name;
    }


    @GetMapping("/hello/{name}")
    public String Hello(@PathVariable("name") String name) {
        return "Hello" + name;
    }

    @GetMapping("/hello/req")
    public String R(@RequestParam String f, @RequestParam(required = false) String i) {
        return "Hello " + f + "   " + i;
    }

    @GetMapping("/password")
    public String password(@RequestHeader("password") String password) {
        if (password == null || password.equals("123")) {
            return "Success";
        }
        return "Error";
    }

    @GetMapping("/massege")
    public Hello main(@RequestHeader("password") String password) {
        Hello message = new Hello("ok", "abs");
        if (!password.equals("123") || password == null) {
            return new Hello("error", "looser");
        } else {
            return new Hello("ok", "molodes");
        }
    }

    @PostMapping("/hello1")
    public Message postModel(@RequestBody Message message) {
        helloRepository.save(message);
        return message;
    }
     @GetMapping("/massegeall")
    public List<Message> getAllMessage() {
        return helloRepository.findAll();
    }
    @GetMapping("/m")
    public List<Message> getAllOld(@RequestParam Integer integer) {
        return helloRepository.getAllOld(integer);
    }
    private class IOExceptoin extends Exception {

    }

    @PostMapping("/image")
    public String handleFileUpload(@RequestParam("file") MultipartFile file) throws IOException {
        String fileName = addImage(file);
        return fileName;
    }

    public String addImage(MultipartFile file) throws IOException {
        byte[] bytes = file.getBytes();
        String modifiedFileName = System.currentTimeMillis() + file.getOriginalFilename().substring(file.getOriginalFilename().length() - 4);
        Path path = Paths.get("F:\\Новая папка\\" + modifiedFileName);
        Files.write(path, bytes);
        return modifiedFileName;
    }

}


