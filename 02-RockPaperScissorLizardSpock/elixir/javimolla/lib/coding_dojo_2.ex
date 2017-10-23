defmodule CodingDojo2 do
  @moduledoc """
  Documentation for CodingDojo2.
  """

  @doc """

  """
  def play(:scissors, :paper), do: :win
  def play(:scissors, :lizard), do: :win

  def play(:paper, :rock), do: :win
  def play(:paper, :spock), do: :win

  def play(:rock, :lizard), do: :win
  def play(:rock, :scissors), do: :win

  def play(:lizard, :spock), do: :win
  def play(:lizard, :paper), do: :win

  def play(:spock, :scissors), do: :win
  def play(:spock, :rock), do: :win

  def play(move1, move2) when move1 == move2, do: :draw

  def play(_, _), do: :lose
end
