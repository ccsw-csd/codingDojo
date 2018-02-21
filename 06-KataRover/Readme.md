# Kata Rover

Develop an api that moves a rover around on a grid.

Rules:

We'll treat the lunar surface as a 100x100 square grid.
Permitted orientations of the Rover will be ('N','E','S','W')
The starting position of the Rover will be the square (0,0) and with orientation' N'.
The moon is round, when we get to square 100, we'll actually be in square 0.
The Rover receives the commands sent one at a time and executes them on the spot.
The commands allowed for the Rover are "char" to minimize bandwidth and are as follows:

- 'F' fordward
- 'B' backward
- 'R' turn right
- 'L' turn left
- 'U' undo last movement