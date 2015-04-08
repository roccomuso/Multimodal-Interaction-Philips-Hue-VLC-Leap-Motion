# Multimodal-Interaction-Philips-Hue-VLC-Leap-Motion
Multimodal Interaction Project using Philips Hue, VLC Player and Leap Motion.

# Introduction:

The goal is to fundamentally transform how people interact with the home environment - Here i'm showing a brief project made in Java to do so.

# What is the Leap Motion?

Leap Motion is a hands tracking controller, Which is made of 2 cameras and 3 Infrared LED.
He could perceive object (hands and fingers) within a distance up to 1 meter.
We can setting it up for providing a better accurancy or tracking speed. 


Let's talk about gestures.
The Gesture represents a recognized movement by the user.

Which kind of gestures does the leap motion tracks?
- Left/right Swipe
- key Tap
- screen tap
- Clockwise or Counterclockwise circle

All Gesture objects belonging to the same recognized movement share the same ID value.
Every single frame will have the same ID if belongs to one single recognized gesture.


Let's analyse the Leap Motion's API:

- What you got when you make a circle with your finger:
	
	- Every gesture frame will have the same ID.
	- Every frame's gesture got a STATE: STATE_START, STATE_UPDATE, STATE_STOP


. . .

The VLC interaction was made thanks to VLC web interface. Allowing to send commands to the player by URL get request:

Examples:

http://localhost:8080/requests/status.xml?command=pl_play
http://localhost:8080/requests/status.xml?command=pl_pause
http://localhost:8080/requests/status.xml?command=pl_stop
http://localhost:8080/requests/status.xml?command=volume&val=500

# What is the Philips Hue?

The philips hue changes the way you use light. It combines new LED and wireless technology to bring smart light bulb in your home. For few dollars you can get the Hue Kit (3 bulbs and the Bridge) and start working with.

The interaction with the Philips Hue Bridge was possible thanks to the RESTful API in JSON developed by philips' engineers. This makes the communication quite simple.

Here you can find a brief video:
- https://www.youtube.com/watch?v=yIIKQUk06jI

Here the italian documentation:

http://www.hackerstribe.com/2014/interazione-multimodale-leap-motion-philips-hue-e-vlc/

