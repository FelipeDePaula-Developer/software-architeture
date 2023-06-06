package com.example.softwarearchitecture.onetoone;

import java.util.ArrayList;
import java.util.List;

public enum BookInMemoryDB {
    INSTANCE;
    private static List<BookDto> list = new ArrayList<BookDto>();
    private static Integer lastId = 0;

    public static Integer getId() {
        return ++lastId;
    }

    public void add(BookDto bookDto) {
        bookDto.setId(getId());
        list.add(bookDto);
    }

    public static List<BookDto> findAll() {
        return list;
    }

    public BookDto findById(Integer id){
        for (BookDto bookDto : list){
            if (bookDto.getId() == id) return bookDto;
        }
        return null;
    }

    public void remove(Integer id){
        BookDto dto = null;
        for (BookDto bookDto : list){
            if (bookDto.getId() == id){
                dto = bookDto;
                break;
            }
        }
        if (null != dto) {list.remove(dto); }
    }

    public void edit(BookDto bookDto){
        for(BookDto dto : list){
            if(dto.getId() == bookDto.getId()){
                dto.setName(bookDto.getName());
                dto.setCity(bookDto.getCity());
            }
        }
    }
}
