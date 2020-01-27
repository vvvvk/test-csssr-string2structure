public class Main {
    public static void main(String[] args) {
        String inputString = "сапог сарай арбуз болт бокс биржа болт дима слон гарда дрезина грипп ";// args[0];
        System.out.println("Строка на входе: " + inputString);
        System.out.println("Отсортированная строка: " + StringToStructureConverter.convert(inputString));
    }
}
