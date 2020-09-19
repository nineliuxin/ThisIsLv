package org.fkit.service;

import java.util.List;

import org.fkit.domain.Focus;
import org.fkit.domain.Gather;

public interface FocusService {
		Focus selectByUser_idAndId(Integer user_id,Integer gather_id);
		void insertFocus(Integer gather_id,Integer user_id);
		Integer SelectCount(Integer gather_id);
		void deleteFocus(Integer gather_id,Integer user_id);
		List<Gather> selectGatherFocus(Integer user_id);
}
