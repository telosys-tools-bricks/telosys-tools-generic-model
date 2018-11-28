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
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.telosys.tools.generic.model.types.AttributeTypeInfo;
import org.telosys.tools.generic.model.types.LanguageType;
import org.telosys.tools.generic.model.types.LiteralValuesProvider;
import org.telosys.tools.generic.model.types.NeutralType;
import org.telosys.tools.generic.model.types.TypeConverter;

public class TypeConvertersDoc extends DocPrinter {

	private final TypeConverter          typeConverter ;
	private final LiteralValuesProvider  literalValuesProvider ;
	
	public TypeConvertersDoc(TypeConverter typeConverter, LiteralValuesProvider literalValuesProvider, BufferedWriter writer ) {
		super(writer);
		this.typeConverter = typeConverter ;
		this.literalValuesProvider = literalValuesProvider ;
	}
	
	public void printDoc() {
		String title = "Type conversion for " + typeConverter.getLanguageName() ;
		printHtmlHeader(title);
		printTypesTable();
		printTypesRemarks();
		printLiteralValuesTable();
		printHtmlFooter();
	}
	
	private void printTypesTable() {
		print("<table style=\"\"> ");
		println();
		println("<colgroup>");
		print(" <col style=\"width: 16%; background-color: GhostWhite ; \">" );
		for ( int n=0 ; n < 6 ; n++ ) { // 6 columns x 14% = 84%
			print(" <col style=\"width: 14%;\">" );
		}
		println();
		println("</colgroup>");

		println("<thead>");
		print(" <tr>");
		print(" <th> Model type </th>" ); 
		print(" <th> Default </th> " );
		print(" <th> @UnsignedType </th>" ); 
		print(" <th> @NotNull </th>" ); 
		print(" <th> @PrimitiveType </th>" ); 
		print(" <th> @ObjectType </th>" );  
		print(" <th> @SqlType </th>" );  
		println("</tr>");
	    println("</thead>");

		println("<tbody>");
		for ( String neutralType : NeutralType.getAllNeutralTypes() ) {
			List<String> types = getSimpleTypes(neutralType); 
			printTypeRow(neutralType, types);
		}		
		println("</tbody>");
		println("</table>");
	}
	
	private List<String> getSimpleTypes(String neutralType) {
		List<String> list = new LinkedList<>();
		
		list.add( getSimpleType(neutralType, AttributeTypeInfo.NONE) ); // "default"
		list.add( getSimpleType(neutralType, AttributeTypeInfo.UNSIGNED_TYPE) );
		list.add( getSimpleType(neutralType, AttributeTypeInfo.NOT_NULL) );
		list.add( getSimpleType(neutralType, AttributeTypeInfo.PRIMITIVE_TYPE) );
		list.add( getSimpleType(neutralType, AttributeTypeInfo.OBJECT_TYPE) );
		list.add( getSimpleType(neutralType, AttributeTypeInfo.SQL_TYPE) );
		
		return list;
	}
	
	private LanguageType getLanguageType(String neutralType) {
		return typeConverter.getType(new AttributeTypeInfo(neutralType, AttributeTypeInfo.NONE));
	}	
	private LanguageType getLanguageType(String neutralType, int info) {
		return typeConverter.getType(new AttributeTypeInfo(neutralType, info));
	}	
	
	private String getSimpleType(String neutralType, int info) {
		LanguageType lt = getLanguageType(neutralType, info);
		return lt.getSimpleType();
	}	
	
	private void printTypeRow(String neutralType, List<String> types) {
				
		print(" <tr>" );
		print(" <td>" + neutralType + "</td>");
		for ( String type : types ) {
			print(" <td>" + type + "</td>");
		}
		print(" </tr>\n" );
	}

	private void printTypesRemarks() {
		List<String >remarks = typeConverter.getComments() ;
		if ( remarks == null || remarks.isEmpty() ) {
			return ;
		}
		print("<h2>Remarks</h2>" );	
		print("<p>" );	
		for ( String s : typeConverter.getComments() ) {
			print( s + "<br>" );	
		}
		print("</p>" );	
	}

	//---------------------------------------------------------------------------------
	/**
	 * Returns all types possibilities for the current language (grouped by neutral type) <br>
	 * e.g. "String", "int", "Integer" etc
	 * @return
	 */
	private List<LanguageType> getAllLanguageTypes() {
		List<LanguageType> list = new LinkedList<>();
		for ( String neutralType : NeutralType.getAllNeutralTypes() ) {
			getLanguageTypesForNeutralType(list, neutralType);
		}		
		return list;
	}
	private void getLanguageTypesForNeutralType(List<LanguageType> list, String neutralType) {
		// Add at least the default type
		addIfNotInList( list, getLanguageType(neutralType, AttributeTypeInfo.NONE ) ) ; // "default type"
		// Add other types 
		addIfNotInList( list, getLanguageType(neutralType, AttributeTypeInfo.UNSIGNED_TYPE ) ) ;
		addIfNotInList( list, getLanguageType(neutralType, AttributeTypeInfo.NOT_NULL ) ) ;
		addIfNotInList( list, getLanguageType(neutralType, AttributeTypeInfo.PRIMITIVE_TYPE ) ) ;
		addIfNotInList( list, getLanguageType(neutralType, AttributeTypeInfo.OBJECT_TYPE ) ) ;
		addIfNotInList( list, getLanguageType(neutralType, AttributeTypeInfo.SQL_TYPE ) ) ;
	}
	private void addIfNotInList(List<LanguageType> list, LanguageType languageType) {
		if ( ! list.contains(languageType) ) {
			list.add(languageType);
		}
	}
	
	private void printLiteralValuesTable() {
		println();
		println("<h2>Literal values </h2>" );	
		println("<table style=\"\"> ");
		println("<colgroup>");
		print(" <col style=\"background-color: GhostWhite ; \">" );
		print(" <col>" );
		print(" <col>" );
		print(" <col>" );
		println();
		println("</colgroup>");

		println("<thead>");
		print(" <tr>");
		print(" <th> Model type </th>" ); 
		print(" <th> Language type </th> " );
		print(" <th> Language full type </th> " );
		print(" <th> Language literal value </th>" ); 
		println("</tr>");
	    println("</thead>");

		println("<tbody>");
		for ( LanguageType languageType : getAllLanguageTypes() ) {
			String literalValue = literalValuesProvider.generateLiteralValue(languageType, 3, 1);
			printLiteralValueRow(languageType, literalValue);
		}		
		println("</tbody>");
		println("</table>");
	}

	private void printLiteralValueRow(LanguageType languageType, String literalValue) {
		
//		literalValuesProvider.getLiteralNull();
//		literalValuesProvider.getEqualsStatement(value, languageType)
		print(" <tr>" );
		print(" <td>" + languageType.getNeutralType() + "</td>");
		print(" <td>" + languageType.getSimpleType() + "</td>");
		print(" <td>" + languageType.getFullType() + "</td>");
		print(" <td>" + literalValue + "</td>");
		print(" </tr>" );
		println();
	}
	
}
