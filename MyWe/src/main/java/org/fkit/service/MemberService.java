package org.fkit.service;

import java.util.List;

import org.fkit.domain.Gather;
import org.fkit.domain.Member;

public interface MemberService {
		Member selectByG_idAndM_id(Integer gather_id,Integer member_id);
		void insertMember(Integer gather_id,Integer member_id);
		Integer SelectCount(Integer gather_id);
		void deleteJoiner(Integer gather_id,Integer member_id);
		List<Gather> selectGatherJoiner(Integer user_id);
		
}
