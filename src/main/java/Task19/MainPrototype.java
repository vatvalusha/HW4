package Task19;

import java.util.Scanner;

/**
 * Created by Valerii Artemenko on 11.03.2017.
 * Generating design pattern.
 */
public class MainPrototype {
    public static void main(String[] args) {
        Article article = Article.createArticle("Pattern", 9, "Valerii");
        System.out.println("Original: " + article);

        Article copy = (Article) article.clone();
        copy.setName("About Thread");
        copy.setCreator("Oleg");
        System.out.println("Copy: " + copy);

        ArticleFactory factory = new ArticleFactory(copy);
        Article articleCopy = factory.makeCopy();
        articleCopy.setPages(8);
        articleCopy.setName("Stream");
        articleCopy.setCreator("Vika");
        System.out.println("Factory copy: " + articleCopy);
    }
}

interface Prototype {
    Object clone();
}

class Article implements Prototype {
    private String name;
    private int pages;
    private String creator;

    public Article(String name, int pages, String creator) {
        this.name = name;
        this.pages = pages;
        this.creator = creator;
    }

    static Article createArticle(String name, int pages, String creator) {
        int newPages = checkPages(pages);
        return new Article(name, newPages, creator);
    }


    public Object clone() {
        return createArticle(name, pages, creator);
    }


    public void setName(String name) {
        this.name = name;
    }


    public void setPages(int pages) {

        this.pages = checkPages(pages);
    }


    public static int checkPages(int pages) {
        Scanner scanner = new Scanner(System.in);
        while (pages < 3 || pages > 10) {
            if (pages < 3)
                System.out.println(View.SMALL_COUNT);
            if (pages > 10)
                System.out.println(View.BIG_COUNT);
            while (!scanner.hasNextInt()) {
                System.out.println(View.INCORRECT_SYMBOL);
                scanner.next();
            }
            pages = scanner.nextInt();
        }
        return pages;
    }

    @Override
    public String toString() {
        return "Article{" +
                "name='" + name + '\'' +
                ", pages=" + pages +
                ", creator='" + creator + '\'' +
                '}';
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }
}

class ArticleFactory {
    Article article;

    public ArticleFactory(Article article) {
        setArticle(article);
    }

    Article makeCopy() {
        return (Article) article.clone();
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}

class View {
    static final public String BIG_COUNT = "Very big count pages for article";
    static final public String SMALL_COUNT = "Very small count pages for article";
    static final public String INCORRECT_SYMBOL = "Input please number";
}