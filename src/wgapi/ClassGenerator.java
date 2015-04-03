package wgapi;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ClassGenerator {
	private static String	newLine	= System.getProperty("line.separator");

	public static void main(String[] args) {
		try {
			Document doc = Jsoup.connect("https://na.wargaming.net/developers/api_reference/wot/account/list/").get();
			Elements sections = doc.getElementsByClass("b-menu_item");
			Elements links = doc.select("a[href]");
			Elements media = doc.select("[src]");
			Elements imports = doc.select("link[href]");

			print("\nSections: (%d)", sections.size());
			for (Element sec : sections) {
				Element menuLink = sec.getElementsByClass("b-menu_link").first();
				print("\n%s:", abbreviate(menuLink.text()));
				for (Element subSection : sec.getElementsByClass("b-menu-sub_item")) {
					Element subLink = subSection.getElementsByClass("b-menu-sub_link").first();
					print("\n%s:", subLink.text());
					for (Element link : subSection.select("a[href]")) {
						print(" * a: <%s>  (%s)", link.attr("abs:href"), trim(link.text(), 35));
					}
				}
			}
			print("\nMedia: (%d)", media.size());
			for (Element src : media) {
				if (src.tagName().equals("img"))
					print(" * %s: <%s> %sx%s (%s)",
							src.tagName(), src.attr("abs:src"), src.attr("width"), src.attr("height"),
							trim(src.attr("alt"), 20));
				else
					print(" * %s: <%s>", src.tagName(), src.attr("abs:src"));
			}

			print("\nImports: (%d)", imports.size());
			for (Element link : imports) {
				print(" * %s <%s> (%s)", link.tagName(), link.attr("abs:href"), link.attr("rel"));
			}

			print("\nLinks: (%d)", links.size());
			for (Element link : links) {
				print(" * a: <%s>  (%s)", link.attr("abs:href"), trim(link.text(), 35));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@SuppressWarnings("unused")
	private static void makeClassFile(String url, File file, String packageName) {
		Writer fileWriter = null;
		BufferedWriter bw = null;

		try {
			fileWriter = new FileWriter(file);
			bw = new BufferedWriter(fileWriter);

			// Header
			bw.write("package " + packageName + ";" + newLine + newLine);
			bw.write("import java.util.ArrayList;" + newLine +
					"import java.util.HashMap;" + newLine +
					"import java.util.List;" + newLine +
					"import java.util.Map;" + newLine + newLine);
			String className = file.getName().split(".")[0];
			bw.write("public class " + className + "{" + newLine + newLine);
			// End Header

			Document doc = Jsoup.connect(url).get();
			Elements responseRows = doc.getElementsByClass("table-result-description").first().getElementsByTag("tbody").first().getElementsByTag("tr");
			for(Element row : responseRows){
				
			}

		} catch (IOException e) {
			System.err.println("Error writing the file : ");
			e.printStackTrace();
		} finally {
			if (bw != null && fileWriter != null) {
				try {
					bw.close();
					fileWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	private static String abbreviate(String s) {
		StringBuilder sb = new StringBuilder(3);
		String[] parts = s.trim().split(" ");
		for (String part : parts) {
			sb.append(part.toLowerCase().substring(0, 1));
		}

		return sb.toString();
	}

	private static void print(String msg, Object... args) {
		System.out.println(String.format(msg, args));
	}

	private static String trim(String s, int width) {
		if (s.length() > width)
			return s.substring(0, width - 1) + ".";
		else
			return s;
	}

}
