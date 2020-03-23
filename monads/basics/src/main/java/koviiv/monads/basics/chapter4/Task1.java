package koviiv.monads.basics.chapter4;

import static koviiv.monads.basics.model.SampleData.johnColtrane;
import static koviiv.monads.basics.model.SampleData.logTask;
import static koviiv.monads.basics.model.SampleData.theBeatles;

import java.util.List;
import java.util.stream.Stream;
import koviiv.monads.basics.model.Artist;

public class Task1 {

    private static final Performance PERFORMANCE = new PerformanceImpl();

    public static void main(String[] args) {

        logTask(1, "getAllMusicians()");
        PERFORMANCE.getAllMusicians().forEach(System.out::println);
        logTask(1, "getAllMusiciansAndGroupName()");
        PERFORMANCE.getAllMusiciansAndGroupName().forEach(System.out::println);

    }

    interface Performance {

        String getName();

        Stream<Artist> getMusicians();

        default Stream<Artist> getAllMusicians() {

            return getMusicians().flatMap(artist -> {
                if (artist.getName().startsWith("The")) {
                    return artist.getMembers();
                } else {
                    return Stream.of(artist);
                }
            });

        }

        default Stream<Artist> getAllMusiciansAndGroupName() {
            return getMusicians().flatMap(artist -> Stream.concat(Stream.of(artist), artist.getMembers()));
        }
    }

    static class PerformanceImpl implements Performance {

        private static final List<Artist> DATA = List.of(johnColtrane, theBeatles);

        @Override
        public String getName() {
            return "SamplePerformance";
        }

        @Override
        public Stream<Artist> getMusicians() {
            return DATA.stream();
        }
    }

}
