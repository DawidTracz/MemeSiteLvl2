//package pl.akademiakodu.repository;
//
//import org.springframework.stereotype.Component;
//
///**
// * Created by User on 03.04.2017.
// */
//@Component
//public class CategoryRepository {
//
//        private static final List<Category> ALL_CATEGORIES = Arrays.asList(
//                new Category(1,"Osoby"),
//                new Category(2,"Sport"),
//                new Category(3,"Memy")
//        );
//        public List<Category> getAllCategories(){
//            return ALL_CATEGORIES;
//        }
//        public Category findById(int id){
//            for (Category category:ALL_CATEGORIES){
//                if (category.getId()==id){
//                    return category;
//                }
//            }
//            return null;
//        }
//    }