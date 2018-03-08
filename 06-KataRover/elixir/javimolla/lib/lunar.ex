defmodule Lunar do
  use Agent

  def new() do
    Agent.start_link(fn ->  %{:orientation => 'N', :x => 0, :y => 0, :last => %{}} end, name: __MODULE__)
  end

  def get(tag) do
    Agent.get(__MODULE__, fn map ->
      Map.get map, tag
    end)
  end

  def send_command('F'), do: move :forward
  def send_command('B'), do: move :backward
  def send_command('L'), do: turn :left
  def send_command('R'), do: turn :right
  def send_command('U'), do: undo()
  
  defp get_axis_and_increment(:forward, 'N'), do: {:y, 1}
  defp get_axis_and_increment(:backward, 'N'), do: {:y, -1}
  defp get_axis_and_increment(:forward, 'S'), do: {:y, -1}
  defp get_axis_and_increment(:backward, 'S'), do: {:y, 1}
  defp get_axis_and_increment(:forward, 'E'), do: {:x, 1}
  defp get_axis_and_increment(:backward, 'E'), do: {:x, -1}
  defp get_axis_and_increment(:forward, 'W'), do: {:x, -1}
  defp get_axis_and_increment(:backward, 'W'), do: {:x, 1}

  defp turn(:left, 'N'), do: 'W'
  defp turn(:right, 'N'), do: 'E'
  defp turn(:left, 'S'), do: 'E'
  defp turn(:right, 'S'), do: 'W'
  defp turn(:left, 'E'), do: 'N'
  defp turn(:right, 'E'), do: 'S'
  defp turn(:left, 'W'), do: 'S'
  defp turn(:right, 'W'), do: 'N'

  defp turn(direction) do
    Agent.get_and_update(__MODULE__, fn map ->
      orientation = Map.get(map, :orientation)
      {:ok, Map.merge(map, %{:orientation => turn(direction, orientation), :last => map})}
    end)
  end

  defp move(direction) do
    Agent.get_and_update(__MODULE__, fn map ->
      {axis, increment} = get_axis_and_increment(direction, Map.get(map, :orientation))

      result = Map.get(map, axis) + increment
      result = cond do
        result < 0 -> 100
        result > 100 -> 0
        true -> result
      end
      {:ok, Map.merge(map, %{axis => result, :last => map})}
    end)
  end

  defp undo do
    Agent.get_and_update(__MODULE__, fn map ->
      {:ok, Map.get(map, :last)}
    end)
  end
end