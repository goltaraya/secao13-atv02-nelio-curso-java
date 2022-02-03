package application;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Comment;
import entities.Post;

public class Program {
	public static void main(String[] args) {

		Locale.setDefault(Locale.UK);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss aa");
		int i, j;

		System.out.print("How many posts do you wanna write? ");
		int n = sc.nextInt();
		sc.nextLine();

		Post[] post = new Post[n];

		for (i = 0; i < n; i++) {
			System.out.println("\n=== POST #" + (i + 1) + " ===");
			System.out.print("Title: ");
			String postTitle = sc.nextLine();

			System.out.print("Content: ");
			String postContent = sc.nextLine();

			System.out.print("Likes: ");
			int postLikes = sc.nextInt();
			post[i] = new Post(new Date(System.currentTimeMillis()), postTitle, postContent, postLikes);

			System.out.print("How many comments does it have? ");
			int commentsQt = sc.nextInt();
			sc.nextLine();

			for (j = 0; j < commentsQt; j++) {
				System.out.print("Comment #" + (j + 1) + ": ");
				String commentText = sc.nextLine();
				Comment comment = new Comment(commentText);
				post[i].addComment(comment);
			}
		}

		for (i = 0; i < post.length; i++) {
			System.out.println("====================");
			System.out.println(post[i].getTitle() + "\n" + post[i].getLikes() + " Likes - "
					+ sdf.format(post[i].getMoment()) + "\n" + post[i].getContent() + "\nComments:");
			post[i].printComments();
			System.out.println();
		}

		sc.close();
	}
}
