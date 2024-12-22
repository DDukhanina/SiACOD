package org.example;

public class Main {
    public static void main(String[] args) {
        BPlusTree bPlusTree = new BPlusTree(10);

        bPlusTree.insert(1, new Data("Wakin' up in the morning's hard"));
        bPlusTree.insert(20, new Data("It's hurting in my chest to breathe"));
        bPlusTree.insert(5, new Data("So hard, but it was not enough"));
        bPlusTree.insert(8, new Data("I'm goin' out to a party"));
        bPlusTree.insert(11, new Data("Sayin' I'm okay, but really I'm cryin'"));
        bPlusTree.insert(23, new Data("Why don't you take him and go to hell"));
        bPlusTree.insert(15, new Data("You're the best and worst of all"));
        bPlusTree.insert(18, new Data("I hope you both go rot in hell"));

        System.out.println("Search result for key 1: " + bPlusTree.search(1));
        System.out.println("Search result for key 5: " + bPlusTree.search(5));
        System.out.println("Search result for key 8: " + bPlusTree.search(8));
        System.out.println("Search result for key 11: " + bPlusTree.search(11));
        System.out.println("Search result for key 15: " + bPlusTree.search(15));
        System.out.println("Search result for key 18: " + bPlusTree.search(18));
        System.out.println("Search result for key 20: " + bPlusTree.search(20));
        System.out.println("Search result for key 23: " + bPlusTree.search(23));
        System.out.println("Search result for key 37: " + bPlusTree.search(37));
    }
}
