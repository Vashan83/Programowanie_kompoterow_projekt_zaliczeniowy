package src;

public class ProgramRuntime {
    public static long startTime;
    public static long endTime;

    public static void printRuntimeDuration() {
        long durationInNano = endTime - startTime;
        double durationInSeconds = durationInNano / 1_000_000_000.0;
        System.out.println("Czas działania (nanosekundy): " + durationInNano);
        System.out.printf("Czas działania (sekundy): %.2f ", durationInSeconds); //printf umożliwia formatowanie wyniku, %.2f - zmiennoprzeczinkowe z dwoma miejscami po przecinku
    }
}
