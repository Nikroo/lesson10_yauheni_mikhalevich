package by.itacademy;
import by.itacademy.processor.Processor;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static final String MAX_FREQUENCY = "Max frequency: ";

    public static void main(String[] args) {

        List<Processor> list = new ArrayList<>();
        list.add(new Processor(null, 5000));
        list.add(new Processor("AMD Ryzen 5 3600", 3600));
        list.add(new Processor("Intel Core i5-10400F", 2900));
        list.add(new Processor("AMD Ryzen 5 2600", 3400));
        list.add(new Processor("IntelCore i7-10700K", 3800));
        list.add(new Processor("AMD Ryzen 5 3500X", 3600));
        list.add(new Processor("Intel Core i9-9900K", 3600));
        list.add(new Processor("AMD Ryzen 5 3600 (BOX)", 3600));
        list.add(new Processor("Intel Core i3-9100F", 3600));
        list.add(new Processor("AMD Ryzen 5 PRO 4650G", 3700));
        list.add(new Processor("Intel Core i9-9900K (BOX)", 3600));
        list.add(new Processor("AMD FX-4300", 3800));
        list.add(new Processor("Intel Core i5-8400 (BOX)", 2800));
        list.add(new Processor("AMD Phenom X4 Quad-Core 9550", 2200));
        list.add(new Processor("Intel Xeon E5-2620", 2000));
        list.add(new Processor("AMD Athlon X2", 3000));
        list.add(new Processor("AMD Athlon X2", 3000));

        Optional<Processor> maybeProcessor = list.stream()
                .reduce((processor1, processor2) -> processor1.getFrequency() > processor2.getFrequency() ? processor1 : processor2);

        System.out.println(MAX_FREQUENCY + maybeProcessor);

        System.out.println();

        List<Processor> processors = list.stream()
                .sorted(Processor::compareTo)
                .peek(e -> e.setName("Processor: "+e.getName()))
                .limit(list.size()-1)
                .collect(Collectors.toList());

        for (Processor element: processors) {
            System.out.println(element);
        }

        list.stream()
                .max(Comparator.comparingInt(Processor::getFrequency))
                .map(Processor::getName)
                .ifPresent(System.out::println);

        list.stream()
                .skip(1)
                .filter(e -> e.getName().startsWith("AMD"))
                .map(Processor::getName)
                .distinct()
                .forEach(System.out::println);

        System.out.println();

        list.stream()
                .filter(frequency -> frequency.getFrequency() > 3600)
                .map(Processor::getFrequency)
                .forEach(System.out::println);

        System.out.println();

    }

}
