package com.example.softwarearchitecture.onetoone.bookmockcontroller;

import com.example.softwarearchitecture.onetoone.BookDto;
import com.example.softwarearchitecture.onetoone.BookInMemoryDB;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

@Controller
@RequestMapping(value = "onetoneuni/mock")
public class BookMockController {
    @PostMapping(value = "/create")
    @ResponseBody
    public void create(@RequestBody BookDto bookDto){
        BookInMemoryDB.INSTANCE.add(bookDto);
    }
    @GetMapping(value = "/findAll")
    public @ResponseBody List<BookDto> findAll(){
        return BookInMemoryDB.findAll();
    }
    @GetMapping(value = "/findById/{bookid}")
    public @ResponseBody BookDto findById(@PathVariable("bookid") Integer bookid){
        return BookInMemoryDB.INSTANCE.findById(bookid);
    }
    @GetMapping(value = "/remove/{bookid}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void remove(@PathVariable("bookid") Integer bookid){
        BookInMemoryDB.INSTANCE.remove(bookid);
    }

    @RequestMapping(value="/edit", method=RequestMethod.POST)
    @ResponseBody
    public void edit(@RequestBody BookDto bookDto){
        BookInMemoryDB.INSTANCE.edit(bookDto);
    }
}
