package ex7;

class MyTv2 {
	boolean isPowerOn;
	int channel;
	int prevChannel;

	void gotoPrevChannel() {
		int temp = this.channel;
		this.channel = prevChannel;
		prevChannel = temp;
	}

	public boolean isPowerOn() {
		return isPowerOn;
	}

	public void setPowerOn(boolean isPowerOn) {
		this.isPowerOn = isPowerOn;
	}

	public int getChannel() {
		return channel;
	}

	public void setChannel(int channel) {
		this.prevChannel = this.channel;
		this.channel = channel;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	int volume;
	final int MAX_VOLUME = 100;
	final int MIN_VOLUME = 0;
	final int MAX_CHANNEL = 100;
	final int MIN_CHANNEL = 1;
	/*
	 * (1) 알맞은 코드를 넣어 완성하시오.
	 */
}