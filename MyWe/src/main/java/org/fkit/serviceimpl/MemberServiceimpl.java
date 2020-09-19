package org.fkit.serviceimpl;

import java.util.List;

import org.fkit.domain.Gather;
import org.fkit.domain.Member;
import org.fkit.mapper.MemberMapper;
import org.fkit.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("memberService")
public class MemberServiceimpl implements MemberService{
	@Autowired
	private MemberMapper memberMapper;
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
	@Override
	public Member selectByG_idAndM_id(Integer gather_id,Integer member_id){
		return memberMapper.selectByG_idAndM_id(gather_id, member_id);
	}
	public void insertMember(Integer gather_id,Integer member_id){
		memberMapper.insertMember(gather_id, member_id);
	}
	public Integer  SelectCount(Integer gather_id){
		return memberMapper.SelectCount(gather_id);
	}
	public void deleteJoiner(Integer gather_id,Integer member_id){
		memberMapper.deleteJoiner(gather_id, member_id);
	}
	public List<Gather> selectGatherJoiner(Integer user_id){
		return memberMapper.selectGatherJoiner(user_id);
	}
}
