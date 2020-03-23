package koviiv.monads.basics.chapter3;

import static koviiv.monads.basics.model.SampleData.aLoveSupreme;
import static koviiv.monads.basics.model.SampleData.johnLennon;
import static koviiv.monads.basics.model.SampleData.logTask;
import static koviiv.monads.basics.model.SampleData.manyTrackAlbum;
import static koviiv.monads.basics.model.SampleData.sampleShortAlbum;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import koviiv.monads.basics.model.Album;
import koviiv.monads.basics.model.Artist;

public class Task1 {

    private static final List<Integer> NUMBERS = List.of(1, 4);
    private static final List<Album> ALBUMS = List.of(aLoveSupreme, sampleShortAlbum, manyTrackAlbum);

    public static void main(String[] args) {

        logTask(1, "A");
        int sumOfElements = addUp(NUMBERS.stream());
        System.out.println(String.format("sum(%s) = %s", NUMBERS, sumOfElements));


        logTask(1, "B");
        List<String> members = listMembers(johnLennon);
        System.out.println(String.format("List for %s : \n %s", johnLennon, members));

        members = listMembers(null);
        System.out.println(String.format("List for %s : \n %s", null, members));


        logTask(1, "C");
        for (Album album : ALBUMS) {
            System.out.println("Original: " + album.getName() + " - " + album.getTrackList().size());
        }

        List<Album> albumsWithTrackCountUpTo3 = filterAlbumsByTrackAmount(ALBUMS, 3);
        for (Album album : albumsWithTrackCountUpTo3) {
            System.out.println("Filtered: " + album.getName() + " - " + album.getTrackList().size());
        }
    }

    public static int addUp(Stream<Integer> numbers) {
        return numbers.reduce(Integer.valueOf(0), Integer::sum);
    }

    public static List<String> listMembers(Artist artist) {
        return Stream.ofNullable(artist)
                .flatMap(member -> Stream.of(member.getName(), member.getNationality()))
                .collect(Collectors.toList());
    }

    public static List<Album> filterAlbumsByTrackAmount(List<Album> albums, int amount) {
        return albums.stream()
                .filter(album -> album.getTrackList().size() <= amount)
                .collect(Collectors.toList());
    }
}
