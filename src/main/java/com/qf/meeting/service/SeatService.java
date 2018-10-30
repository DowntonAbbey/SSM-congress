package com.qf.meeting.service;

import java.util.List;

import com.qf.meeting.bean.Seat;

public interface SeatService {

	public List<Seat> getList();

	public List<Seat> getByIds(List<Integer> ids);

	public List<Seat> getByNoticeIds(List<Integer> noticeIds);

	public Seat getById(Integer seatId);

	public int add(Seat seat);

	public int update(Seat seat);

	public int deleteById(Integer seatId);

	public int deleteByIds(List<Integer> ids);

	public int deleteByNoticeIds(List<Integer> noticeIds);
}
