defmodule Potter do
  @moduledoc """
  Documentation for Potter.
  """
  
  def price([]) do
    0
  end 

  def price(books) when is_list(books) and length(books) == 1 do
    8
  end

  def price(books) when is_list(books) do
    # Los agrupo según el libro
    # [0, 0, 1, 2, 2, 3] pasaría a ser [%{0 => [0, 0]}, %{1 => [1]} ...]
    prepared = Enum.group_by(books, fn(book) -> book end)
    |> Enum.map(fn(x) -> 
      # Me quedo sólo con la parte de listado ya que se ha convertido en un map
      # [%{0 => [0, 0]}, %{1 => [1]} ...] pasaría a ser [[0, 0], [1], ...]
      elem(x, 1)
    end)

    # Obtenemos listados de libros 
    # [[0, 0], [1], [2, 2], [3]] pasaría a ser [[0, 1, 2, 3], [0, 2]]
    get_lists(prepared, 0, max_length(prepared))
    |> Enum.scan(0, fn(x, price) -> 
      y = Enum.filter(x, fn(x) -> x != nil end)
      num_books = length(y)
      # Aplicamos un descuento u otro dependiendo del número de libros distintos
      discount = 1 - (case num_books do
        7 -> 0.55
        _ -> (num_books - 1) * 0.05
      end)
      price + num_books * 8 * discount
    end)
    |> Enum.max
  end

  def get_lists(_, index, max) when index == max do
    []
  end

  def get_lists(list, index, max) do
    [Enum.map(list, fn(x) -> 
      case length(x) > index do
        true -> 
          {value, _} = List.pop_at x, index
          value
        false -> nil
      end
    end) | get_lists(list, index + 1, max)]
  end

  defp max_length(list) do
    list |> Enum.scan(0, fn(x, c) ->
        if length(x) > c, do: length(x), else: c
      end)
      |> Enum.max
  end
end