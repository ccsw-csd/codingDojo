defmodule LunarTest do
  use ExUnit.Case

  def check(orientation, x, y) do
    assert Lunar.get(:orientation) == orientation
    assert Lunar.get(:x) == x
    assert Lunar.get(:y) == y
  end

  setup do
    Lunar.new
    :ok
  end

  test "none movements results initial position" do
    check 'N', 0, 0
  end

  test "forward results zero one" do
    Lunar.send_command 'F'
    
    check 'N', 0, 1
  end

  test "two times forward result zero two" do
    Lunar.send_command 'F'
    Lunar.send_command 'F'

    check 'N', 0, 2
  end

  test "turn left return w orientation" do
    Lunar.send_command 'L'

    check 'W', 0, 0
  end

  test "turn left right return initial position" do
    Lunar.send_command 'L'
    Lunar.send_command 'R'

    check 'N', 0, 0
  end

  test "forward and backward return inital position" do
    Lunar.send_command 'F'
    Lunar.send_command 'B'

    check 'N', 0, 0
  end

  test "turn right and forward return 1 0" do
    Lunar.send_command 'R'
    Lunar.send_command 'F'
    
    check 'E', 1, 0
  end

  test "turn left and backward return 1 0" do
    Lunar.send_command 'L'
    Lunar.send_command 'B'
    
    check 'W', 1, 0
  end

  test "move forward and undo return initial position" do
    Lunar.send_command 'F'
    Lunar.send_command 'U'
    
    check 'N', 0, 0
  end

  test "move forward, turn left and undo once return 1 0" do
    Lunar.send_command 'F'
    Lunar.send_command 'L'
    Lunar.send_command 'U'
    
    check 'N', 0, 1
  end

  test "move forward, turn left and undo twice return initial position" do
    Lunar.send_command 'F'
    Lunar.send_command 'L'
    Lunar.send_command 'U'
    Lunar.send_command 'U'
    
    check 'N', 0, 0
  end
end
