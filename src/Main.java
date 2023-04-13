public class Main {
    public static void main(String[] args) {
        CustomList <Integer> list=new CustomList<>();
        list.addLast(32);
        list.addLast(64);
        System.out.println(list.getLast());
        System.out.println(list.removeFirst());
        System.out.println(list.getFirst());
        System.out.println(list.iterator().next());
        list.stream().map(o->100+o).forEach(System.out::println);

    }
}