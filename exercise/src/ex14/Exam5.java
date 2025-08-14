package ex14;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilterWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

public class Exam5 {
	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println("USAGE: java Exercise14_5 TAGET_FILE RESULT_FILE");
			System.exit(0);
		}
		String inputFile = args[0];
		String outputFile = args[1];
		try {
			BufferedReader input = new BufferedReader(new FileReader(inputFile));
			HtmlTagFilterWriter output = new HtmlTagFilterWriter(new FileWriter(outputFile));
			int ch = 0;
			while ((ch = input.read()) != -1) {
				output.write(ch);
			}
			output.write(output.tmp.toString());
			input.close();
			output.close();
		} catch (IOException e) {
		}
	}
}

class HtmlTagFilterWriter extends FilterWriter {
	StringWriter tmp = new StringWriter();
	boolean inTag = false;

	HtmlTagFilterWriter(Writer out) {
		super(out);
	}

	public void write(int c) throws IOException {
		char ch = (char) c;
		if (ch == '<') {
			inTag = true;
			tmp.write(ch);
			return;
		}

		if (inTag) {
			tmp.write(ch);
			if (ch == '>') {
				inTag = false;
				tmp.getBuffer().setLength(0);
			}
			return;
		}

		out.write(ch);
	}
}