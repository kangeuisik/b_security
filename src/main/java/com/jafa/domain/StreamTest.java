package com.jafa.domain;

import java.util.ArrayList;

import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;

public class StreamTest {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("황인범");
		list.add("손흥민");
		list.add("김민재");
		list.add("이강인");

		list.stream().forEach(p->System.out.println(p));
		List<MemberName> collect = list.stream().map(n->new MemberName(n)).collect(Collectors.toList());

	}
}
@AllArgsConstructor
class MemberName{
	String name;
}