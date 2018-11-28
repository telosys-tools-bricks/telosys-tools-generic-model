/**
 *  Copyright (C) 2008-2017  Telosys project org. ( http://www.telosys.org/ )
 *
 *  Licensed under the GNU LESSER GENERAL PUBLIC LICENSE, Version 3.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *          http://www.gnu.org/licenses/lgpl.html
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.telosys.tools.generic.model.doctools;

import java.io.BufferedWriter;
import java.io.IOException;

public abstract class DocPrinter {

	private final BufferedWriter writer ;
	
	public DocPrinter( BufferedWriter writer ) {
		this.writer = writer ;
	}

	//----------------------------------------------------------------
	
	protected void println() {
		print("\n");
	}
	
	protected void println(String s) {
		print(s + "\n");
	}
	
	protected void print(String s) {
		try {
			writer.write(s);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	//----------------------------------------------------------------

	protected void printHtmlHeader(String title) {
		println("<!DOCTYPE html>" );
		println("<html lang=\"en\">" );
		println("<head>");
		println(" <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
		println(" <title>" + title + "</title>");
		printHtmlStyle();
		println("</head>");
		println();
		println("<body>");
		println("<h1>" + title + "</h1>");
	}
	
	private void printHtmlStyle() {
		println(" <style>" );
		println("  table { border-collapse: collapse; }" );
		println("  table, th, td { border: 1px solid black; } " );
		println("  th, td { padding: 15px; text-align: left; }" );
		println("  th { font-family: Courier New; font-weight: bold; background-color: #4CAF50; color: white; }" );
		println("  td { font-family: Courier New; font-weight: bold; }" );
		println("  p { font-family: Courier New; font-weight: bold; }" );
		println(" </style>" );
	}

	protected void printHtmlFooter() {
		println("<br>");
		println("</body>");
		println("</html>");
	}

}
