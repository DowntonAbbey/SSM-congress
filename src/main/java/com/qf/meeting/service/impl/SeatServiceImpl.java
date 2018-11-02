package com.qf.meeting.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qf.meeting.bean.Seat;
import com.qf.meeting.mapper.SeatMapper;
import com.qf.meeting.service.SeatService;

@Service
@Transactional
public class SeatServiceImpl implements SeatService{

	@Autowired
	private SeatMapper seatMapper;
	
	@Override
	public List<Seat> getList() {
		return seatMapper.getList();
	}

	@Override
	public List<Seat> getByIds(List<Integer> ids) {
		return seatMapper.getByIds(ids);
	}

	@Override
	public List<Seat> getByNoticeIds(List<Integer> noticeIds) {
		return seatMapper.getByNoticeIds(noticeIds);
	}

	@Override
	public Seat getById(Integer seatId) {
		return seatMapper.getById(seatId);
	}

	@Override
	public int add(Seat seat) {
		return seatMapper.add(seat);
	}

	@Override
	public int update(Seat seat) {
		return seatMapper.update(seat);
	}

	@Override
	public int deleteById(Integer seatId) {
		return seatMapper.deleteById(seatId);
	}

	@Override
	public int deleteByIds(List<Integer> ids) {
		return seatMapper.deleteByIds(ids);
	}

	@Override
	public int deleteByNoticeIds(List<Integer> noticeIds) {
		return seatMapper.deleteByNoticeIds(noticeIds);
	}

	@Override
	public Seat getByNoticeId(Integer noticeId) {
		return seatMapper.getByNoticeId(noticeId);
	}
}
