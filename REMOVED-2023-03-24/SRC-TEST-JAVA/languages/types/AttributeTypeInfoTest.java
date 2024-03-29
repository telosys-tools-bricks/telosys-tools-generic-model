package org.telosys.tools.generic.model.languages.types;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import static org.telosys.tools.generic.model.languages.types.AttributeTypeInfo.*;

import org.junit.Test;
import org.telosys.tools.generic.model.languages.types.AttributeTypeInfo;
import org.telosys.tools.generic.model.types.NeutralType;

public class AttributeTypeInfoTest  {

	@Test
	public void test1() {
		AttributeTypeInfo attributeTypeInfo = new AttributeTypeInfo(NeutralType.STRING, NONE);
		System.out.println(attributeTypeInfo);
		assertFalse( attributeTypeInfo.isNotNull() );
		assertFalse( attributeTypeInfo.isPrimitiveTypeExpected() );
		assertFalse( attributeTypeInfo.isObjectTypeExpected() );
		assertFalse( attributeTypeInfo.isUnsignedTypeExpected() );
//		assertFalse( attributeTypeInfo.isSqlTypeExpected() );
	}
	@Test
	public void test2() {
		AttributeTypeInfo attributeTypeInfo = new AttributeTypeInfo(NeutralType.STRING, NOT_NULL);
		System.out.println(attributeTypeInfo);
		assertTrue( attributeTypeInfo.isNotNull() );
		assertFalse( attributeTypeInfo.isPrimitiveTypeExpected() );
		assertFalse( attributeTypeInfo.isObjectTypeExpected() );
		assertFalse( attributeTypeInfo.isUnsignedTypeExpected() );
//		assertFalse( attributeTypeInfo.isSqlTypeExpected() );
	}
	@Test
	public void test3() {
		AttributeTypeInfo attributeTypeInfo = new AttributeTypeInfo(NeutralType.STRING, PRIMITIVE_TYPE);
		System.out.println(attributeTypeInfo);
		assertFalse( attributeTypeInfo.isNotNull() );
		assertTrue( attributeTypeInfo.isPrimitiveTypeExpected() );
		assertFalse( attributeTypeInfo.isObjectTypeExpected() );
		assertFalse( attributeTypeInfo.isUnsignedTypeExpected() );
//		assertFalse( attributeTypeInfo.isSqlTypeExpected() );
	}
	@Test
	public void test4() {
		AttributeTypeInfo attributeTypeInfo = new AttributeTypeInfo(NeutralType.STRING, OBJECT_TYPE);
		System.out.println(attributeTypeInfo);
		assertFalse( attributeTypeInfo.isNotNull() );
		assertFalse( attributeTypeInfo.isPrimitiveTypeExpected() );
		assertTrue( attributeTypeInfo.isObjectTypeExpected() );
		assertFalse( attributeTypeInfo.isUnsignedTypeExpected() );
//		assertFalse( attributeTypeInfo.isSqlTypeExpected() );
	}
	@Test
	public void test5() {
		AttributeTypeInfo attributeTypeInfo = new AttributeTypeInfo(NeutralType.STRING, UNSIGNED_TYPE);
		System.out.println(attributeTypeInfo);
		assertFalse( attributeTypeInfo.isNotNull() );
		assertFalse( attributeTypeInfo.isPrimitiveTypeExpected() );
		assertFalse( attributeTypeInfo.isObjectTypeExpected() );
		assertTrue( attributeTypeInfo.isUnsignedTypeExpected() );
//		assertFalse( attributeTypeInfo.isSqlTypeExpected() );
	}
//	@Test
//	public void test6() {
//		AttributeTypeInfo attributeTypeInfo = new AttributeTypeInfo(NeutralType.STRING, SQL_TYPE);
//		System.out.println(attributeTypeInfo);
//		assertFalse( attributeTypeInfo.isNotNull() );
//		assertFalse( attributeTypeInfo.isPrimitiveTypeExpected() );
//		assertFalse( attributeTypeInfo.isObjectTypeExpected() );
//		assertFalse( attributeTypeInfo.isUnsignedTypeExpected() );
////		assertTrue( attributeTypeInfo.isSqlTypeExpected() );
//	}
//	@Test
//	public void test7() {
//		AttributeTypeInfo attributeTypeInfo = new AttributeTypeInfo(NeutralType.STRING, NOT_NULL + SQL_TYPE);
//		System.out.println(attributeTypeInfo);
//		assertTrue( attributeTypeInfo.isNotNull() );
//		assertFalse( attributeTypeInfo.isPrimitiveTypeExpected() );
//		assertFalse( attributeTypeInfo.isObjectTypeExpected() );
//		assertFalse( attributeTypeInfo.isUnsignedTypeExpected() );
////		assertTrue( attributeTypeInfo.isSqlTypeExpected() );
//	}
//	@Test
//	public void test8() {
//		AttributeTypeInfo attributeTypeInfo = new AttributeTypeInfo(NeutralType.STRING, NOT_NULL + OBJECT_TYPE + SQL_TYPE );
//		System.out.println(attributeTypeInfo);
//		assertTrue( attributeTypeInfo.isNotNull() );
//		assertFalse( attributeTypeInfo.isPrimitiveTypeExpected() );
//		assertTrue( attributeTypeInfo.isObjectTypeExpected() );
//		assertFalse( attributeTypeInfo.isUnsignedTypeExpected() );
////		assertTrue( attributeTypeInfo.isSqlTypeExpected() );
//	}
	@Test
	public void test9() {
		AttributeTypeInfo attributeTypeInfo = new AttributeTypeInfo(NeutralType.STRING, 
//				NOT_NULL + PRIMITIVE_TYPE + OBJECT_TYPE + UNSIGNED_TYPE + SQL_TYPE);
				NOT_NULL + PRIMITIVE_TYPE + OBJECT_TYPE + UNSIGNED_TYPE );
		System.out.println(attributeTypeInfo);
		assertTrue( attributeTypeInfo.isNotNull() );
		assertTrue( attributeTypeInfo.isPrimitiveTypeExpected() );
		assertTrue( attributeTypeInfo.isObjectTypeExpected() );
		assertTrue( attributeTypeInfo.isUnsignedTypeExpected() );
//		assertTrue( attributeTypeInfo.isSqlTypeExpected() );
	}
	@Test
	public void test10() {
		int typeInfo = 0 ;
		typeInfo += NOT_NULL ;
		typeInfo += PRIMITIVE_TYPE ;
		
		AttributeTypeInfo attributeTypeInfo = new AttributeTypeInfo(NeutralType.STRING, typeInfo );
		System.out.println(attributeTypeInfo);
		assertTrue( attributeTypeInfo.isNotNull() );
		assertTrue( attributeTypeInfo.isPrimitiveTypeExpected() );
		assertFalse( attributeTypeInfo.isObjectTypeExpected() );
		assertFalse( attributeTypeInfo.isUnsignedTypeExpected() );
//		assertFalse( attributeTypeInfo.isSqlTypeExpected() );
	}
	@Test
	public void test11() {
		int typeInfo = 0 ;
		typeInfo += NOT_NULL ;
		typeInfo += PRIMITIVE_TYPE ;
		typeInfo += OBJECT_TYPE ;
		typeInfo += UNSIGNED_TYPE ;
		
		AttributeTypeInfo attributeTypeInfo = new AttributeTypeInfo(NeutralType.STRING, typeInfo );
		System.out.println(attributeTypeInfo);
		assertTrue( attributeTypeInfo.isNotNull() );
		assertTrue( attributeTypeInfo.isPrimitiveTypeExpected() );
		assertTrue( attributeTypeInfo.isObjectTypeExpected() );
		assertTrue( attributeTypeInfo.isUnsignedTypeExpected() );
//		assertFalse( attributeTypeInfo.isSqlTypeExpected() );
	}

	@Test
	public void test12() {
		int typeInfo = 0 ;
		typeInfo += NOT_NULL ;
		typeInfo += OBJECT_TYPE ;
		
		AttributeTypeInfo attributeTypeInfo = new AttributeTypeInfo(NeutralType.SHORT, typeInfo );
		System.out.println(attributeTypeInfo);
		assertTrue( attributeTypeInfo.isNotNull() );
		assertFalse( attributeTypeInfo.isPrimitiveTypeExpected() );
		assertTrue( attributeTypeInfo.isObjectTypeExpected() );
		assertFalse( attributeTypeInfo.isUnsignedTypeExpected() );
//		assertFalse( attributeTypeInfo.isSqlTypeExpected() );
	}
}
