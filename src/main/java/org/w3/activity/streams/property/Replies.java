package org.w3.activity.streams.property;

import java.net.URI;
import java.util.List;

public class Replies {
	private String type;
	private Long totalItems;
	private List<ReplyItem> items;

	public class ReplyItem {
		private String summary;
		private String type;
		private String content;
		private URI inReplyTo;
	}

}
