package vn.edu.likelion.book_store_manager.utils;

import lombok.Data;
import org.springframework.stereotype.Component;
import vn.edu.likelion.book_store_manager.entity.BookEntity;

import java.util.ArrayList;

@Component
@Data
public class Util {

    public Iterable<BookEntity> sortByPrice(ArrayList<BookEntity> arrayList){
        BookEntity temp;
        for( int i=0 ; i<arrayList.size() - 1 ; i++ ){
            for ( int j= i + 1 ; j<arrayList.size() ; j++ ){
                if( arrayList.get(i).getPrice() < arrayList.get(j).getPrice() ){
                    temp = arrayList.get(i);
                    arrayList.set(i,arrayList.get(j));
                    arrayList.set(j,temp);
                }
            }
        }
        return arrayList;
    }
}
