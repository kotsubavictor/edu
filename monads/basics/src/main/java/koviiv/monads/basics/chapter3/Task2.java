package koviiv.monads.basics.chapter3;

import static koviiv.monads.basics.model.SampleData.getThreeArtists;
import static koviiv.monads.basics.model.SampleData.logTask;

import java.util.List;
import koviiv.monads.basics.model.Artist;

public class Task2 {

    public static void main(String[] args) {

        logTask(2);
        List<Artist> artists = getThreeArtists();
        artists.forEach(artist -> System.out.println(artist.getName() + " - " + artist.getMembers().count()));

        Long numberOfMembers = countNumberOfMembers(artists);

        System.out.println("Number of members: " + numberOfMembers);
    }

    public static Long countNumberOfMembers(List<Artist> artists) {
        return artists.stream()
                .map(artist -> artist.getMembers().count())
                .reduce(0L, Long::sum);
    }

}
