package com.jafa.domain;

public class MemberTypeTest {
	public static void main(String[] args) {
		System.out.println(MemberType.ROLE_ADMIN);
		System.out.println(MemberType.ROLE_ADMIN.ordinal()); //서수?
		System.out.println(MemberType.ROLE_SUB_ADMIN.ordinal()); //순서 배열로 치면 인덱스번호
		System.out.println(MemberType.ROLE_REGULAR_MEMBER.name());
		
		System.out.println(MemberType.ROLE_ADMIN.getName());
		
	}
}
