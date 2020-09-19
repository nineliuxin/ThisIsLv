package org.fkit.service;

import org.fkit.domain.Userfocus;

public interface UserfocusService {
		Userfocus selectFocus(Integer uid,Integer id);
		void insertFocus(Integer id,Integer uid);
		void deleteFocus(Integer id,Integer uid);
}
