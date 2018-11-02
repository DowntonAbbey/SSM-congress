package com.qf.meeting.mapper;

import java.util.List;


import com.qf.meeting.bean.Seat;

public interface SeatMapper {

	public List<Seat> getList();

	public List<Seat> getByIds(List<Integer> ids);
	
	public List<Seat> getByNoticeIds(List<Integer> noticeIds);

	public Seat getById(Integer seatId);
	
	public Seat getByNoticeId(Integer noticeId);

	public int add(Seat seat);

	public int update(Seat seat);

	public int deleteById(Integer seatId);

	public int deleteByIds(List<Integer> ids);
	
	public int deleteByNoticeIds(List<Integer> noticeIds);
}
